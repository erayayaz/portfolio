package com.ex.portfolio.portfolio.service;

import com.ex.portfolio.portfolio.dto.AboutDto;
import com.ex.portfolio.portfolio.dto.converter.AboutDtoConverter;
import com.ex.portfolio.portfolio.exception.GenericException;
import com.ex.portfolio.portfolio.model.About;
import com.ex.portfolio.portfolio.repository.AboutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutService {

    private final AboutRepository aboutRepository;
    private final AboutDtoConverter aboutDtoConverter;

    public AboutDto getAbout() {
        Optional<AboutDto> optAbout = aboutRepository.findAll()
                .stream()
                .findFirst()
                .map(aboutDtoConverter::convert);

        if (optAbout.isEmpty()) {
            throw new GenericException(HttpStatus.NO_CONTENT, "No record for about");
        }

        return optAbout.get();
    }

    private Optional<About> getAboutWithMessage(String aboutText) {
        return aboutRepository.findByAboutText(aboutText);
    }
}
