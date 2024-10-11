// // document.addEventListener("DOMContentLoaded", function() {
// //     const buttondetail = document.getElementById("details");
// //     const listDiv = document.getElementById("popup1");
// //     console.log(listDiv);
// //     console.log(buttondetail);
// //     buttondetail.addEventListener("click", function() {
// //         listDiv.style.display = "block";
// //     });
// // });
//
// // document.addEventListener("DOMContentLoaded", function() {
// //     document.querySelectorAll(".details-button").forEach(button => {
// //         button.addEventListener("click", function() {
// //             const requestId = this.getAttribute("data-request-id");
// //             const listDiv = document.getElementById("popup1");
// //             listDiv.style.display = "block";
// //         });
// //     });
// //
// //     // Pour fermer les popups
// //     document.querySelectorAll(".close").forEach(closeBtn => {
// //         closeBtn.addEventListener("click", function() {
// //             this.closest(".overlay").style.display = "none";
// //         });
// //     });
// //
// //     // Pour ouvrir le popup de mise à jour de statut
// //     document.querySelectorAll(".update-status").forEach(button => {
// //         button.addEventListener("click", function() {
// //             document.getElementById("popup2").style.display = "block";
// //         });
// //     });
// // });
//
//
// // document.addEventListener("DOMContentLoaded", function() {
// //     const detailButtons = document.querySelectorAll(".details-button");
// //     const popup = document.getElementById("popup1");
// //     const closeButton = popup.querySelector(".close");
// //
// //     detailButtons.forEach(button => {
// //         button.addEventListener("click", function(e) {
// //             e.preventDefault();
// //             const requestId = this.getAttribute("data-request-id");
// //             fetchRequestStatusList(requestId);
// //         });
// //     });
// //
// //     closeButton.addEventListener("click", function(e) {
// //         e.preventDefault();
// //         popup.style.display = "none";
// //     });
// //
// //     function fetchRequestStatusList(requestId) {
// //         fetch(`${pageContext.request.contextPath}/details?requestId=${requestId}`)
// //             .then(response => response.text())
// //             .then(html => {
// //                 document.getElementById("popup1").innerHTML = html;
// //                 popup.style.display = "block";
// //             })
// //             .catch(error => console.error('Error:', error));
// //     }
// // });
//
//
// document.addEventListener("DOMContentLoaded", function() {
//
//     let contextPath = "${pageContext.request.contextPath}";
//
//     console.log("DOM fully loaded");
//     const detailButtons = document.querySelectorAll(".details-button");
//     const popup = document.getElementById("popup1");
//     const closeButton = popup.querySelector(".close");
//
//     console.log("Number of detail buttons:", detailButtons.length);
//
//     detailButtons.forEach(button => {
//         button.addEventListener("click", function (e) {
//             console.log("Detail button clicked");
//             e.preventDefault();
//             const requestId = this.getAttribute("data-request-id");
//             console.log("Request ID:", requestId);
//             fetchRequestStatusList(requestId);
//         });
//     });
//
//     closeButton.addEventListener("click", function (e) {
//         console.log("Close button clicked");
//         e.preventDefault();
//         popup.style.display = "none";
//     });
//
//     function fetchRequestStatusList(requestId) {
//         console.log("Fetching request status list for ID:", requestId);
//         fetch(`${contextPath}/details?requestId=${requestId}`)
//             .then(response => response.text())
//             .then(html => {
//                 console.log("Received HTML:", html);
//                 document.getElementById("popup1").innerHTML = html;
//                 popup.style.display = "block";
//             })
//             .catch(error => console.error('Error:', error));
//     }
// });

function showPopup(id) {
    document.getElementById('popup-' + id).style.display = 'block';
}

function hidePopup(id) {
    document.getElementById('popup-' + id).style.display = 'none';
}
