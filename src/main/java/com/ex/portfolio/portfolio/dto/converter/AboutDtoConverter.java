package com.ex.portfolio.portfolio.dto.converter;

import com.ex.portfolio.portfolio.dto.AboutDto;
import com.ex.portfolio.portfolio.model.About;
import org.springframework.stereotype.Component;

@Component
public class AboutDtoConverter {

    public AboutDto convert(About from) {
        return new AboutDto(
                from.getAboutText()
        );
    }
}
