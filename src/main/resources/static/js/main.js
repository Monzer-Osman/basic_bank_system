transferLink = document.getElementById("transfer-link");
transferButton = document.getElementById("submit-btn");
userBalance = document.getElementById("div-balance");
transferAmount = document.getElementById("amount-inp");
warnMessage = document.querySelector(".invalid-amount");
form = document.querySelector("form");

transferLink.onclick = function(event) { 
    form.classList.remove("hide");
}

transferButton.onclick = function(event) { 
    if (userBalance.innerText < transferAmount.value || transferAmount.value < 0) { 
        warnMessage.classList.remove("invalid-amount");
        event.preventDefault();
    }
}