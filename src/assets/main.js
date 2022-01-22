const searchInput = document.querySelector(".content__search");
const searchInputBtn = document.querySelector(".content__search__icon");

searchInput.addEventListener("keyup", ({ key }) => {
  if (key === "Enter" && searchInput.value !== "") {
    window.location.replace(
      `https://www.google.com/search?q=${searchInput.value}`
    );
  }
});
searchInputBtn.addEventListener("click", (e) => {
  e.preventDefault();
  if (searchInput.value !== "" && searchInput.value !== " ") {
    window.location.replace(
      `https://www.google.com/search?q=${searchInput.value}`
    );
  }
});
