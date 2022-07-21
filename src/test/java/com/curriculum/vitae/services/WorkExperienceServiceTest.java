package com.curriculum.vitae.services;

import com.curriculum.vitae.mappers.Mapper;
import com.curriculum.vitae.models.WorkExperience;
import com.curriculum.vitae.repositories.WorkExperienceRepository;
import com.curriculum.vitae.services.impl.WorkExperienceServiceImpl;
import com.curriculum.vitae.utils.GenerateObjects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WorkExperienceServiceTest extends GenerateObjects {

    @Mock
    private WorkExperienceRepository workExperienceRepository;

    @InjectMocks
    private WorkExperienceServiceImpl workExperienceService;

    void setUp(){
        when(workExperienceRepository.findByBusinessAndInitDate(anyString(),any())).thenReturn(Optional.ofNullable(null));
    }
    @Test
    void whenSaveIsOK(){

        try (MockedStatic<Mapper> mapper = mockStatic(Mapper.class)) {
            mapper.when(() -> Mapper.mapWorkExperienceDTOtoWorkExperience(any())).thenReturn(new WorkExperience());
            workExperienceService.save(this.createDto());
            verify(workExperienceRepository).findByBusinessAndInitDate(anyString(),any());
        }


    }
}
