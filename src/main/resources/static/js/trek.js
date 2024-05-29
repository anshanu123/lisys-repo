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




// Upcoming Events

document.addEventListener('DOMContentLoaded', () => {
    const container = document.querySelector('.card-container');
    const prevBtn = document.querySelector('.slider-button.prev');
    const nextBtn = document.querySelector('.slider-button.next');

    let scrollAmount = 0;
    const scrollStep = container.clientWidth / 3; // Adjust scroll step to show 3 cards

    nextBtn.addEventListener('click', () => {
        if (scrollAmount < container.scrollWidth - container.clientWidth) {
            scrollAmount += scrollStep;
            container.scrollTo({
                left: scrollAmount,
                behavior: 'smooth'
            });
        }
    });

    prevBtn.addEventListener('click', () => {
        if (scrollAmount > 0) {
            scrollAmount -= scrollStep;
            container.scrollTo({
                left: scrollAmount,
                behavior: 'smooth'
            });
        }
    });

    // Show/hide search form
    const searchBtn = document.getElementById('search-btn');
    const searchForm = document.getElementById('search-form');
    const closeSearchBtn = document.getElementById('close-search');

    searchBtn.addEventListener('click', () => {
        searchForm.style.display = 'flex';
    });

    closeSearchBtn.addEventListener('click', () => {
        searchForm.style.display = 'none';
    });
});
