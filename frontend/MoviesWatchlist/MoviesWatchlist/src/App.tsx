import { useState } from "react";
import './App.css'
import Rentals from "./components/Rentals";
import Movie from "./components/Movie";

type Movie = {
  id: number;
  name: string;
  rating: number;
  watched: boolean;
};

function App() {
  const [movieName, setMovieName] = useState("");
  const [rating, setRating] = useState(1);
  const [movies, setMovies] = useState<Movie[]>([]);
  const [searchTerm, setSearchTerm] = useState("");

  const addMovie = () => {
    if (movieName.trim() === "") {
      alert("Movie Name cannot be Empty!!");
      return;
    }

    const newMovie: Movie = {
      id: Date.now(),
      name: movieName,
      rating: rating,
      watched: false,
    };

    setMovies([...movies, newMovie]);
    setMovieName("");
    setRating(1);
  };

  const deleteMovie = (id: number) => {
    const updatedMovies = movies.filter((movie) => movie.id !== id);
    setMovies(updatedMovies);
  };

  const toggleWatched = (id: number) => {
    const updatedMovies = movies.map((movie) =>
      movie.id === id ? { ...movie, watched: !movie.watched } : movie
    );

    setMovies(updatedMovies);
  };

  const filteredMovies = movies.filter((movie) =>
    movie.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const clearAllMovies = () => {
    setMovies([]);
  };

  return (
    <div className="app-container">

      <Rentals>
      </Rentals>
        <Movie name='Avatar ' ></Movie>
        <Movie name="Avengers"></Movie>
        <Movie name="Spider Name" ></Movie>

      <div className="app-header">
        <h1>🎬 Movie Watchlist</h1>
        <p>Track movies you want to watch</p>
      </div>

      <div className="card">
        <label className="label">Movie Name</label>
        <input
          type="text"
          placeholder="Enter movie name..."
          value={movieName}
          onChange={(e) => setMovieName(e.target.value)}
        />

        <label className="label" style={{ marginTop: "12px" }}>
          Rating
        </label>
        <select
          value={rating}
          onChange={(e) => setRating(Number(e.target.value))}
        >
          <option value={1}>⭐ 1</option>
          <option value={2}>⭐⭐ 2</option>
          <option value={3}>⭐⭐⭐ 3</option>
          <option value={4}>⭐⭐⭐⭐ 4</option>
          <option value={5}>⭐⭐⭐⭐⭐ 5</option>
        </select>

        <button className="add-btn" onClick={addMovie}>
          + Add to Watchlist
        </button>
      </div>

      <div className="card">
        <input
          className="search-input"
          type="text"
          placeholder="Search movies..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
      </div>

      <div className="count-row">
        <span>Movies in Watchlist: {movies.length}</span>
        {movies.length > 0 && (
          <button className="clear-btn" onClick={clearAllMovies}>
            Clear All
          </button>
        )}
      </div>

      {movies.length === 0 ? (
        <p className="empty-text">
          Your watchlist is empty. Add your first movie!
        </p>
      ) : filteredMovies.length === 0 ? (
        <p className="empty-text">
          No movies found. Try a different search!
        </p>
      ) : (
        <ul className="movie-list">
          {filteredMovies.map((movie) => (
            <li key={movie.id} className="movie-item">
              <div>
                <div className="movie-title">{movie.name}</div>
                <div className="movie-rating">
                  {"⭐".repeat(movie.rating)}
                </div>
              </div>

              <div className="movie-actions">
                <button
                  className="icon-btn"
                  onClick={() => toggleWatched(movie.id)}
                >
                  {movie.watched ? "👁‍🗨" : "👁"}
                </button>

                <button
                  className="icon-btn"
                  onClick={() => deleteMovie(movie.id)}
                >
                  🗑
                </button>
              </div>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;
