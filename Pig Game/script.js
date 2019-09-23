var dice,currentScore,activePlayer,score,goal;
init();
console.log("xl");
document.querySelector(".btn_roll").addEventListener('click',function() {
  //console.log("aye");
  if(goal)
  {
    dice = Math.floor(Math.random()*6)+1;
    //document.querySelector(".round-score-1").textContent=dice;
    document.querySelector(".dice1").textContent=dice;
    if(dice !== 1)
    {
      currentScore+=dice;
      if((score[activePlayer]+currentScore)>=20)
      {
        document.querySelector(".current-"+ activePlayer).textContent="0";
        score[activePlayer]+=currentScore;
        document.querySelector(".round-score-" + activePlayer).textContent=score[activePlayer];
        document.querySelector(".win").textContent="Winner is player " + activePlayer;
        goal=false;
      }
      else {
        document.querySelector(".current-"+ activePlayer).textContent=currentScore;
      }
    }
    else {
      currentScore=0;
      document.querySelector(".current-"+ activePlayer).textContent="0";
      activePlayer==1?activePlayer=2:activePlayer=1;
    }
  }
})

document.querySelector(".btn_hold").addEventListener('click',function() {
  if(goal)
  {
    score[activePlayer]+=currentScore;
    document.querySelector(".round-score-" + activePlayer).textContent=score[activePlayer];
    currentScore=0;
    document.querySelector(".current-"+ activePlayer).textContent="0";
    activePlayer==1?activePlayer=2:activePlayer=1;
  }
})

document.querySelector(".btn_new").addEventListener('click',init);

function init()
{
  currentScore=0;
  activePlayer=1;
  score=[0,0,0];
  goal=true;
  document.querySelector(".round-score-1").textContent="0";
  document.querySelector(".round-score-2").textContent="0";
  document.querySelector(".current-1").textContent="0";
  document.querySelector(".current-2").textContent="0";
  document.querySelector(".win").textContent="";
}
