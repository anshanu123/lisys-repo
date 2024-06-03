var navLinks = document.querySelectorAll('.navbar a');
var menuBtn = document.querySelector('#menu-btn');
var navClose = document.querySelector('#nav-close');
var navbar = document.querySelector('.navbar');

menuBtn.addEventListener('click', () => {
    navbar.classList.add('active');
});

navClose.addEventListener('click', () => {
    navbar.classList.remove('active');
});

navLinks.forEach(link => {
    link.addEventListener('click', () => {
        navbar.classList.remove('active');
    });
});

window.onscroll = () => {
    navbar.classList.remove('active');
};

var searchForm = document.querySelector('.search-form');
var searchBtn = document.querySelector('#search-btn');
var closeSearch = document.querySelector('#close-search');

searchBtn.addEventListener('click', () => {
    searchForm.classList.add('active');
});

closeSearch.addEventListener('click', () => {
    searchForm.classList.remove('active');
});
