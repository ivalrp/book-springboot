package com.subrutin.catalog.service.impl;

import com.subrutin.catalog.domain.Author;
import com.subrutin.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.catalog.dto.AuthorResponseDTO;
import com.subrutin.catalog.dto.AuthorUpdateRequestDTO;
import com.subrutin.catalog.exception.BadRequestException;
import com.subrutin.catalog.exception.ResourceNotFoundException;
import com.subrutin.catalog.repository.AuthorRepository;
import com.subrutin.catalog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorServiceImp implements AuthorService {

    private final AuthorRepository authorRepository;
    @Override
    public AuthorResponseDTO findAuthorById(String id) {
        //1.fecth data from database
        Optional<Author> authorOptional = authorRepository.findBySecureId(id);
//                .orElseThrow(()-> new ResourceNotFoundException("invalid_id"));
        //2. auhtor -> authorresponseDTO
        if (authorOptional.isEmpty()){
            throw new ResourceNotFoundException("Invalid_Id");
        }
        Author author = authorOptional.get();
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
    public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto) {
        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(()-> new BadRequestException("INVALID_AUTHOR_ID"));
        author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
        author.setBirthDate(dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(String authorId) {
        //HARD DELETE menjadi soft delete seleteah anotasi @SQLDelete dana @Where ditambahkan

        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(()-> new BadRequestException("INVALID_AUTHOR_ID"));
        authorRepository.delete(author);

        //SOFT DELETE
//        Author author = authorRepository.findByIdAndDeletedFalse(authorId)
//                .orElseThrow(()-> new BadRequestException("INVALID_AUTHOR_ID"));
//        author.setDeleted(Boolean.TRUE);
//        authorRepository.save(author);

    }

    @Override
    public List<Author> findAuthors(List<String> authorIdList) {
        List<Author> authorList = authorRepository.findBySecureIdIn(authorIdList);
        if (authorList.isEmpty())
            throw new BadRequestException("author cant empty");

        return authorList;
    }

    @Override
    public List<AuthorResponseDTO> constructDTO(List<Author> authors) {
        return authors.stream().map(a -> {
            AuthorResponseDTO dto = new AuthorResponseDTO();
            dto.setAuthorName(a.getName());
            dto.setBirthDate(a.getBirthDate().toEpochDay());

            return dto;
        }).collect(Collectors.toList());
    }
}
