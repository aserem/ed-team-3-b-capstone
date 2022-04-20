package com.example.edteam3bcapstone.service;

import com.example.edteam3bcapstone.domain.Film;
import com.example.edteam3bcapstone.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FilmRepository filmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return filmRepository;
    }

    @Override
    public Film findByTitle(final String title) {
        return filmRepository.findByTitle(title);
    }
}
