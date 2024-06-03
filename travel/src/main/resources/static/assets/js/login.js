/*const loginBtn = document.querySelector('#login-btn');
const popup = document.querySelector('.popup');
const closeBtn = document.querySelector('.close-btn');

loginBtn.addEventListener('click', () => {
    popup.classList.add('active');
    
})
closeBtn.addEventListener('click', () => {
    popup.classList.remove('active');
})
*/


// 레이어 팝업 열기
document.getElementById('showPopup').addEventListener('click', function() {
    document.getElementById('popupContainer').style.display = 'block';
});

// 레이어 팝업 닫기
document.getElementById('closePopup').addEventListener('click', function() {
    document.getElementById('popupContainer').style.display = 'none';
});
/**
 * 
 */
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
  container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
  container.classList.remove("right-panel-active");
})

document.getElementById('closePopup').addEventListener('click', function() {
    popup.classList.remove('active');
});
