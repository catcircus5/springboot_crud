import React, { useEffect, useState } from "react";
import api from "../api";
import BookForm from "../components/BookForm";
import BookList from "../components/BookList";

function Home() {
  const [books, setBooks] = useState([]);
  const [editingBook, setEditingBook] = useState(null);

  const fetchBooks = async () => {
    try {
      const res = await api.get("/books");
      setBooks(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    fetchBooks();
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>Book Store</h1>

      <BookForm
        refresh={fetchBooks}
        editingBook={editingBook}
        setEditingBook={setEditingBook}
      />

      <BookList
        books={books}
        refresh={fetchBooks}
        setEditingBook={setEditingBook}
      />
    </div>
  );
}

export default Home;
