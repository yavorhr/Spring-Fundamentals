function checkDropdowns() {
    const dropdown1 = document.querySelector('.dropdown1');
    const dropdown2 = document.querySelector('.dropdown2');
    const submitButton = document.getElementById('submitButton');

    // Check if both dropdowns have a selected value
    if (dropdown1.value && dropdown2.value) {
        submitButton.disabled = false; // Enable button if both are selected
    } else {
        submitButton.disabled = true; // Keep button disabled if one or both are not selected
    }
}

// Attach event listeners to both dropdowns
document.querySelector('.dropdown1').addEventListener('change', checkDropdowns);
document.querySelector('.dropdown2').addEventListener('change', checkDropdowns);