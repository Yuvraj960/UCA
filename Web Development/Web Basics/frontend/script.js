// // hoisting example

// // function checkValues(val) {
// //     console.log(x);

// //     // val would be initialized only if x is even as then only we enter if condition
// //     if (val % 2 === 0) {
// //         var x = "Even"; //will move to the top of the function scope but not initialized yet until this if block is executed
// //         console.log(x);
        
// //     } else {
// //         console.log("Odd"); 
// //     }
    
// //     console.log(x);
// // }

// // checkValues(25);


function foo() {
    console.log("Hello, World!");
    let thing = document.getElementById("hehe");
    if (!thing) {
        console.error("Element with id 'hehe' not found.");
        return;
    }

    thing.style.backgroundColor = "rgba(120, 220, 100, 0.9)";
    thing.style.borderRadius = "100px";
    thing.style.border = "0px";
}

var listo = [];

function loadProducts(callback) {
    setTimeout(() => {
        listo = productListFromServer; // Load products from the server 
        callback(); // ✅ CALL the callback after listo is loaded
    }, 1000);
}

function renderProducts() {
    if (listo.length === 0) {
        console.error("Product list is empty.");
        return;
    }

    let thingy = document.getElementById("data");
    if (!thingy) {
        console.error("Element with id 'data' not found.");
        return;
    }

    thingy.innerHTML = `
        <table>
            <thead>
                <tr>
                    <th>S.No</th>               
                    <th>Name</th>
                    <th>Value</th>
                    <th>Description</th>
                </tr> 
            </thead>
            <tbody>
                ${listo.map((item, idx) => `
                    <tr>
                        <td>${idx + 1}</td>
                        <td>${item.name}</td>
                        <td>${item.value}</td>
                        <td>${item.description}</td>
                    </tr>
                `).join('')}
            </tbody>
        </table>`;
}

foo();
loadProducts(renderProducts); // ✅ Pass actual function that renders after listo is ready
