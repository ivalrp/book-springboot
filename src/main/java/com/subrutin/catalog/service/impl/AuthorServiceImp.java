package com.subrutin.catalog.service.impl;

import com.subrutin.catalog.dto.AuthorResponseDTO;
import com.subrutin.catalog.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImp implements AuthorService {

    @Override
    public AuthorResponseDTO findAuthorById(Long id) {
        //1.fecth data from database
        //2. auhtor -> authorresponseDTO
        return null;
    }
}
