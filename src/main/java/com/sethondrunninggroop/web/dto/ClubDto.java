package com.sethondrunninggroop.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDto {
    private long id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "PhotoUrl should not be empty")
    private String photoUrl;
    @NotEmpty(message = "Content should not be empty")
    private String content;
    private LocalDateTime createOn;
    private LocalDateTime updateOn;
    private List<EventDto> events;
}
