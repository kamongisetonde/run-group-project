package com.sethondrunninggroop.web.service.Imp;

import com.sethondrunninggroop.web.dto.ClubDto;
import com.sethondrunninggroop.web.models.Club;
import com.sethondrunninggroop.web.repository.ClubRepository;
import com.sethondrunninggroop.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.sethondrunninggroop.web.mapper.ClubMapper.mapToClub;
import static com.sethondrunninggroop.web.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;
    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs()  {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club)->mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById( long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClub(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }
}
