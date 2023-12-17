package com.sethondrunninggroop.web.service;

import com.sethondrunninggroop.web.dto.ClubDto;
import com.sethondrunninggroop.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(Club clubDto);

    ClubDto findClubById( long clubId);

    void updateClub(ClubDto club);

    void delete(Long clubId);

    List<ClubDto> searchClub(String query);
}
