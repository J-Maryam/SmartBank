function validateForm() {
    // Récupérer les valeurs des champs
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    let errors = [];

    // Valider l'email (doit contenir '@' et un domaine valide)
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        errors.push('Veuillez saisir une adresse email valide.');
    }

    const phonePattern = /^0[67][0-9]{8}$/;

    if (phone.trim() === '') {
        errors.push('Téléphone mobile est obligatoire.');
    } else if (!phonePattern.test(phone)) {
        errors.push('Le numéro de téléphone doit être un nombre de 10 chiffres, commencer par 0, et le deuxième chiffre doit être 6 ou 7.');
    }


    if (errors.length > 0) {
        showModal(errors);
        return false;
    } else {
        window.location.href = 'index3.html';
        return false;
    }
}

function showModal(errors) {
    let errorList = document.getElementById('errorList');
    errorList.innerHTML = '';

    errors.forEach(error => {
        let li = document.createElement('li');
        li.style.marginBottom ='8px';
        li.textContent = error;
        errorList.appendChild(li);
    });

    let modal = document.getElementById('errorModal');
    modal.style.display = 'block';
}

// Fermer la modale
function closeModal() {
    let modal = document.getElementById('errorModal');
    modal.style.display = 'none';

}