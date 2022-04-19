package com.example.edteam3bcapstone.service;

import com.example.edteam3bcapstone.domain.TvShow;
import com.example.edteam3bcapstone.repository.TvShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TvShowServiceImpl extends BaseServiceImpl<TvShow> implements TvShowService {
    private final TvShowRepository tvShowRepository;

    @Override
    public JpaRepository<TvShow, Long> getRepository() {
        return tvShowRepository;
    }
}
