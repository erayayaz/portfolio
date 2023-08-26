package com.ex.portfolio.portfolio.dto.converter;

import com.ex.portfolio.portfolio.dto.ContactDto;
import com.ex.portfolio.portfolio.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactDtoConverter {
    public ContactDto convert(Contact from) {
        return new ContactDto(from.getEmail(), from.getInstaUrl(), from.getLinkedInUrl(), from.getTwitterUrl());
    }
}
