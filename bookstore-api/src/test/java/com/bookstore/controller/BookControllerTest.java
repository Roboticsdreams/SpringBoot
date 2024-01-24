package com.bookstore.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bookstore.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void verifyAllBooks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/books").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5))).andDo(print());
	}
	
	@Test
	public void verifyBookById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/books/3").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.author").exists())
		.andExpect(jsonPath("$.publisher").exists())
		.andExpect(jsonPath("$.unitPrice").exists())
		.andExpect(jsonPath("$.availQuantity").exists())
		.andExpect(jsonPath("$.id").value("3"))
		.andExpect(jsonPath("$.name").value("Book3"))
		.andExpect(jsonPath("$.author").value("Author3"))
		.andExpect(jsonPath("$.publisher").value("Publisher3"))
		.andExpect(jsonPath("$.unitPrice").value(3000))
		.andExpect(jsonPath("$.availQuantity").value(5))
		.andDo(print());
	}
	
	@Test
	public void verifyInvalidBookId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/books/0").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Book doesn´t exist"))
		.andDo(print());
	}
	
	@Test
	public void verifyNullBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/books/6").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Book doesn´t exist"))
		.andDo(print());
	}
	
	@Test
	public void verifyDeleteBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/books/4").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value(200))
		.andExpect(jsonPath("$.message").value("Book has been deleted"))
		.andDo(print());
	}
	
	@Test
	public void verifyInvalidBookToDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/books/9").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Book to delete doesn´t exist"))
		.andDo(print());
	}
	
	
	@Test
	public void verifySaveBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/books/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"id\" : \"6\", \"name\" : \"Book\", \"author\" : \"Author\", \"publisher\" : \"Publisher\", \"unitPrice\" :100, \"availQuantity\":5 }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.author").exists())
		.andExpect(jsonPath("$.publisher").exists())
		.andExpect(jsonPath("$.unitPrice").exists())
		.andExpect(jsonPath("$.availQuantity").exists())
		.andExpect(jsonPath("$.id").value("6"))
		.andExpect(jsonPath("$.name").value("Book"))
		.andExpect(jsonPath("$.author").value("Author"))
		.andExpect(jsonPath("$.publisher").value("Publisher"))
		.andExpect(jsonPath("$.unitPrice").value(100))
		.andExpect(jsonPath("$.availQuantity").value(5))
		.andDo(print());
	}
	
	@Test
	public void verifyMalformedSaveBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/books/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\" : \"Book8\", \"author\" : \"Author8\", \"publisher\" : \"Publisher8\", \"unitPrice\" :100, \"availQuality\":5 }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Payload malformed, id must not be defined"))
		.andDo(print());
	}
	
	@Test
	public void verifyUpdateBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/books/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"id\" : \"1\", \"name\" : \"Book1\", \"author\" : \"Author1\", \"publisher\" : \"Publisher1\", \"unitPrice\" :100, \"availQuantity\":5 }")
        .accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.author").exists())
		.andExpect(jsonPath("$.publisher").exists())
		.andExpect(jsonPath("$.unitPrice").exists())
		.andExpect(jsonPath("$.availQuantity").exists())
		.andExpect(jsonPath("$.id").value("1"))
		.andExpect(jsonPath("$.name").value("Book1"))
		.andExpect(jsonPath("$.author").value("Author1"))
		.andExpect(jsonPath("$.publisher").value("Publisher1"))
		.andExpect(jsonPath("$.unitPrice").value(100))
		.andExpect(jsonPath("$.availQuantity").value(5))
		.andDo(print());
	}
	
	@Test
	public void verifyInvalidBookUpdate() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/books/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"id\" : \"8\", \"name\" : \"Book8\", \"author\" : \"Author8\", \"publisher\" : \"Publisher8\", \"unitPrice\" :100, \"availQuantity\":5 }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("Book to update doesn´t exist"))
		.andDo(print());
	}

}
