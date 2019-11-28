var phoneNo = document.getElementById("tel1")

function validatePhone() {
  if(phoneNo.value.length != 10) {
    confirm_password.setCustomValidity("Wrong Contact No");
  } else {
    alert("Hii")
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePhone;
