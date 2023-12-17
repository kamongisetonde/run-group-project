package com.sethondrunninggroop.web.mapper;

import com.sethondrunninggroop.web.dto.ClubDto;
import com.sethondrunninggroop.web.models.Club;

import java.util.stream.Collectors;

import static com.sethondrunninggroop.web.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club mapToClub(ClubDto club) {
        Club clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .build();
        return clubDto;
    }

    public static ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .events(club.getEvents().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}

