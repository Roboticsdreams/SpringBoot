package com.dailycodebufferspringdatajpa;


import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages(value = {
        "com.dailycodebufferspringdatajpa"
})
@SuiteDisplayName("Test Suite")
public class TestSuite {}
