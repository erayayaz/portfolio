package com.ex.portfolio.portfolio.service;

import com.ex.portfolio.dto.ProjectDto;
import com.ex.portfolio.portfolio.dto.AboutDto;
import com.ex.portfolio.portfolio.dto.converter.AboutDtoConverter;
import com.ex.portfolio.portfolio.exception.GenericException;
import com.ex.portfolio.portfolio.model.About;
import com.ex.portfolio.portfolio.repository.AboutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutService {

    private final AboutRepository aboutRepository;
    private final AboutDtoConverter aboutDtoConverter;

    @Transactional
    public AboutDto saveAbout(AboutDto aboutDto) {
        String aboutText = aboutDto.getAboutText();
        Optional<About> about = getAboutWithMessage(aboutText);

        if (about.isPresent()) {
            throw new GenericException(HttpStatus.CONFLICT, "There is a same record with same about message");
        }

        About newAbout = new About(aboutText);
        return aboutDtoConverter.convert(aboutRepository.save(newAbout));
    }

    @Transactional
    public AboutDto getAbout() {
        Optional<AboutDto> optAbout = aboutRepository.findAll()
                .stream()
                .findFirst()
                .map(aboutDtoConverter::convert);

        return optAbout.isEmpty() ? new AboutDto() : optAbout.get();
    }

    @Transactional
    public AboutDto updateAbout(AboutDto aboutDto) {
        String aboutText = aboutDto.getAboutText();
        Optional<About> about = getAboutWithMessage(aboutText);

        if (about.isEmpty()) {
            throw new GenericException(HttpStatus.NOT_FOUND, "There is a no record with about message");
        }

        About updatedAbout = new About(about.get().getId(), aboutText);
        return aboutDtoConverter.convert(aboutRepository.save(updatedAbout));
    }

    private Optional<About> getAboutWithMessage(String aboutText) {
        return aboutRepository.findByAboutText(aboutText);
    }
}
