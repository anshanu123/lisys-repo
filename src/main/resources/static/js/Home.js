document.addEventListener('DOMContentLoaded', () => {
    const navLinks = document.querySelectorAll('.navbar a');
    const menuBtn = document.querySelector('#menu-btn');
    const navClose = document.querySelector('#nav-close');
    const navbar = document.querySelector('.navbar');
    const searchForm = document.querySelector('.search-form');
    const searchBtn = document.querySelector('#search-btn');
    const closeSearch = document.querySelector('#close-search');

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

    searchBtn.addEventListener('click', () => {
        searchForm.classList.add('active');
    });

    closeSearch.addEventListener('click', () => {
        searchForm.classList.remove('active');
    });

    new Swiper('.home-slider', {
        loop: true,
        grabCursor: true,
        autoplay: {
            delay: 3000,
            disableOnInteraction: false,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });

    new Swiper('.review-slider', {
        loop: true,
        grabCursor: true,
        spaceBetween: 20,
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        breakpoints: {
            0: {
                slidesPerView: 1,
            },
            640: {
                slidesPerView: 2,
            },
            768: {
                slidesPerView: 3,
            },
        },
    });
});
