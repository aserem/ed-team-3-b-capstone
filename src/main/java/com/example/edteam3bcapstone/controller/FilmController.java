package com.example.edteam3bcapstone.controller;


import com.example.edteam3bcapstone.domain.Film;
import com.example.edteam3bcapstone.service.BaseService;
import com.example.edteam3bcapstone.service.FilmService;
import com.example.edteam3bcapstone.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
@RequiredArgsConstructor
public class FilmController extends AbstractController<Film> {
    private final FilmService filmService;

    @Override
    protected BaseService<Film, Long> getBaseService() {
        return filmService;
    }

    @GetMapping(params = {"title"})
    public ResponseEntity<ApiResponse<Film>> findByTitle(@RequestParam String title) {
        return ResponseEntity.ok(ApiResponse.<Film>builder().data(filmService.findByTitle(title)).build());
    }
}
