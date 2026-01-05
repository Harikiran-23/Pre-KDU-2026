import React, { useState, useEffect, useRef } from "react";

interface Props {
  name: string;
}

const Movie = ({ name }: Props) => {
  const [count, setCount] = useState(10);
  const [isRunning, setIsRunning] = useState(false);

  useEffect(() => {
    let timerId = null;

    if (isRunning && count > 0) {
      timerId = setInterval(() => {
        setCount((prevCount) => prevCount - 1);
      }, 1000);
    } else if (count === 0) {
      setIsRunning(false);
    }


    return () => {
      if (timerId) {
        clearInterval(timerId);
      }
    };
  }, [isRunning, count]);

  const handleStart = () => {
    setIsRunning(true);
  };

  return (
    <div>
      <h2>
        {name} : {count}{" "}
      </h2>
      <button onClick={handleStart} disabled={isRunning || count === 0}>
        {isRunning ? "Running" : "Start"}
      </button>
    </div>
  );
};

export default Movie;
