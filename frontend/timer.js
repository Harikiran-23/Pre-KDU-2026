let minutes = 25;
let seconds = 0;
let timer = null;
let isRunning = false;
let sessions = 0;
let defaultMinutes = 25;

const display = document.getElementById("ticking");
const sessionCount = document.getElementById("sessionCount");
const input = document.getElementById("inputValue")

function updateDisp(){
    const mm = minutes.toString().padStart(2, "0");
    const ss = seconds.toString().padStart(2, "0");
    display.textContent = `${mm}:${ss}`;
}


function start(){
    if(isRunning) return;

    isRunning = true;

    timer = setInterval(() =>{
        if(seconds > 0){
            seconds--;
        }
        else{
            if(minutes > 0){
                minutes--;
                seconds = 59;
            }
            else{
                clearInterval(timer);

                alert("Session Completed");
                sessions++;

                sessionCount.textContent = sessions;

                minutes = defaultMinutes;
                seconds = 0;
            }
        }
        updateDisp();
    }, 100);
}

function pause(){
    clearInterval(timer);
    isRunning = false;
}

function reset(){
    clearInterval(timer);
    isRunning = false;
    minutes = defaultMinutes;
    seconds = 0;
    updateDisp();
}

function setTimer(){
    const value = parseInt(input.value);

    if(isNaN(value) || value <1 || value >60){
        alert("Enter number between 1 and 60");
        return;
    }

    clearInterval(timer);
    isRunning = false;

    // defaultMinutes = value;
    minutes = value;
    seconds = 0;

    updateDisp();
}

updateDisp();