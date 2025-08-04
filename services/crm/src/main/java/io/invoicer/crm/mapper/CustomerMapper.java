package io.invoicer.crm.mapper;

import io.invoicer.crm.dto.customer.CustomerDTO;
import io.invoicer.crm.dto.customer.CustomerTagDTO;
import io.invoicer.crm.model.Customer;
import io.invoicer.crm.model.CustomerTag;
import io.invoicer.crm.model.Tag;
import io.invoicer.crm.repository.TagRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {
        AddressMapper.class,
        NoteMapper.class,
        ContactPersonMapper.class,
        TagMapper.class
})
public abstract class CustomerMapper {

    @Autowired
    protected TagRepository tagRepository;

    public abstract CustomerDTO toDTO(Customer customer);

    public abstract Customer toEntity(CustomerDTO customerDTO);

    @AfterMapping
    public void afterMapping(@MappingTarget Customer customer, CustomerDTO customerDTO) {
        customer.getAddresses().forEach(address -> address.setCustomer(customer));
        customer.getNotes().forEach(note -> note.setCustomer(customer));
        customer.getContactPeople().forEach(person -> person.setCustomer(customer));

        //Generate new tags or update the current ones
        List<Tag> tags = new ArrayList<>();

        customerDTO.getTagList().forEach(tag -> {
            Optional<Tag> optionalTag = tagRepository.findTagByLabelIs(tag.getLabel());
            Tag t = optionalTag.orElseGet(Tag::new);
            t.setLabel(tag.getLabel());
            tags.add(t);
        });

        tagRepository.saveAll(tags);

        List<CustomerTag> customerTags = tags.stream().map(tag -> {
            CustomerTag t = new CustomerTag();
            t.setTag(tag);
            t.setCustomer(customer);

            return t;
        }).collect(Collectors.toList());

        customer.setTags(customerTags);
    }

    @AfterMapping
    public void afterMappingDto(@MappingTarget CustomerDTO customerDTO, Customer customer) {
        customerDTO.setTagList(customer.getTags().stream().map(ct -> CustomerTagDTO
                .builder()
                .id(ct.getTag().getId())
                .label(ct.getTag().getLabel())
                .build()).collect(Collectors.toList()));
    }
}