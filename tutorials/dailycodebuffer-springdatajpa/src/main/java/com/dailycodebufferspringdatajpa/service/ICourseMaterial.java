package com.dailycodebufferspringdatajpa.service;

import com.dailycodebufferspringdatajpa.entity.CourseMaterial;

import java.util.List;

public interface ICourseMaterial {
    CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial);
    List<CourseMaterial> getAllCourseMaterials();
    void deleteAllCourseMaterials();
}
