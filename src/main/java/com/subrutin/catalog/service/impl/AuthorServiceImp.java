package com.subrutin.catalog.service.impl;

import com.subrutin.catalog.domain.Author;
import com.subrutin.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.dto.AuthorResponseDTO;
import com.subrutin.catalog.dto.AuthorUpdateRequestDTO;
import com.subrutin.catalog.exception.BadRequestException;
import com.subrutin.catalog.repository.AuthorRepository;
import com.subrutin.catalog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorServiceImp implements AuthorService {

    private final AuthorRepository authorRepository;
    @Override
    public AuthorResponseDTO findAuthorById(Long id) {
        //1.fecth data from database
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("INVALID_AUTHOR_ID"));
        //2. auhtor -> authorresponseDTO
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());
        return dto;
    }

    @Override
    public void createNewAuthor(List<AuthorCreateRequestDTO> dtos) {

        List<Author> authors = dtos.stream().map((dto) ->
                {
                    Author author = new Author();
                    author.setName(dto.getAuthorName());
                    author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
                    return author;
                }
        ).collect(Collectors.toList());
        authorRepository.saveAll(authors);
    }

    @Override
    public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()-> new BadRequestException("INVALID_AUTHOR_ID"));
        author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
        author.setBirthDate(dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        //HARD DELETE menjadi soft delete seleteah anotasi @SQLDelete dana @Where ditambahkan
        authorRepository.deleteById(authorId);

        //SOFT DELETE
//        Author author = authorRepository.findByIdAndDeletedFalse(authorId)
//                .orElseThrow(()-> new BadRequestException("INVALID_AUTHOR_ID"));
//        author.setDeleted(Boolean.TRUE);
//        authorRepository.save(author);

    }
}
