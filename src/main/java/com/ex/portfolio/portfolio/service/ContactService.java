package com.ex.portfolio.portfolio.service;

import com.ex.portfolio.portfolio.dto.ContactDto;
import com.ex.portfolio.portfolio.dto.converter.ContactDtoConverter;
import com.ex.portfolio.portfolio.exception.GenericException;
import com.ex.portfolio.portfolio.repository.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactDtoConverter contactDtoConverter;

    @Transactional
    public ContactDto getContact() {
        return getContactDto();
    }

    public boolean sendMail() {

        ContactDto contactDto = getContactDto();

        return false;
    }

    private ContactDto getContactDto() {
        Optional<ContactDto> optContact = contactRepository.findAll()
                .stream()
                .findFirst()
                .map(contactDtoConverter::convert);

        if (optContact.isEmpty()) {
            throw new GenericException(HttpStatus.NO_CONTENT, "No record for contact");
        }

        return optContact.get();
    }
}
