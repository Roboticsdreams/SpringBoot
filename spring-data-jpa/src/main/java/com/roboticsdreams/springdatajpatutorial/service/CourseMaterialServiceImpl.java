package com.roboticsdreams.springdatajpatutorial.service;

import com.roboticsdreams.springdatajpatutorial.entity.CourseMaterial;
import com.roboticsdreams.springdatajpatutorial.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialServiceImpl implements ICourseMaterial {
    @Autowired
    public CourseMaterialRepository courseMaterialRepository;

    @Override
    public CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial) {
        return courseMaterialRepository.save(courseMaterial);
    }
    @Override
    public List<CourseMaterial> getAllCourseMaterials() {
        return courseMaterialRepository.findAll();
    }

    @Override
    public void deleteAllCourseMaterials() {
        courseMaterialRepository.deleteAll();
    }
}
