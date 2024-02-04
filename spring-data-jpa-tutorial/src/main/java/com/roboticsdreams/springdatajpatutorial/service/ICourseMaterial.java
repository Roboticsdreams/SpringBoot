package com.roboticsdreams.springdatajpatutorial.service;

import com.roboticsdreams.springdatajpatutorial.entity.CourseMaterial;

import java.util.List;

public interface ICourseMaterial {
    CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial);
    List<CourseMaterial> getAllCourseMaterials();
    void deleteAllCourseMaterials();
}
