CREATE TABLE IF NOT EXISTS tbl_book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    authorname VARCHAR(255),
    category VARCHAR(255),
    price DECIMAL(10, 2)
);;

INSERT INTO TBL_BOOK (name, authorname, category, price) VALUES 
('book1', 'author1', 'category1', 10), 
('book2', 'author2', 'category2', 20), 
('book3', 'author3', 'category3', 30), 
('book4', 'author4', 'category4', 40), 
('book5', 'author5', 'category5', 50), 
('book6', 'author6', 'category6', 60), 
('book7', 'author7', 'category7', 70), 
('book8', 'author8', 'category8', 80), 
('book9', 'author9', 'category9', 90), 
('book10', 'author10', 'category10', 100);