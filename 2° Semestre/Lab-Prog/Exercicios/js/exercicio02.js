const frm = document.querySelector("form");
const msg = document.querySelector("pre");

frm.rbPizza.addEventListener("click", () => {
    frm.inPizza.className = "exibe"
    frm.inBebida.className = "oculta"
})

frm.rbBebida.addEventListener("click", () => {
    frm.inPizza.className = "oculta"
    frm.inBebida.className = "exibe"
})

frm.inDetalhes.addEventListener("focus", () =>{
    if(frm.rbPizza.checked){
        const pizza = frm.inPizza.value
        let num = pizza == "media" ? 2 : pizza == "grande" ? 3 : 4
        frm.inDetalhes.placeholder = "Até " + num + " sabores"
    };
});


frm.inDetalhes.addEventListener("blur", () => {
    frm.inDetalhes.placeholder = "";
})

// let produtos = []; 
// frm.addEventListener("submit", function(e) {
//     e.preventDefault(); 

//     let tipoProduto = "";
//     let detalhesProduto = "";

//     if (frm.rbPizza.checked) {
//         tipoProduto = "Pizza";
//         detalhesProduto = frm.inPizza.value;
//         produtos.push({ tipo: tipoProduto, tamanho: detalhesProduto, sabor: frm.inDetalhes.value });
//     } 
    
//     if (frm.rbBebida.checked) {
//         tipoProduto = "Bebida";
//         detalhesProduto = frm.inDetalhes.value; 
//         produtos.push({ tipo: tipoProduto, sabor: detalhesProduto });
//     }

//     let mensagem = "Produtos Adicionados:\n";
//     produtos.forEach(produto => {
//         if (produto.tamanho) {
//             mensagem += "Tipo: " + produto.tipo + ", Tamanho: " + produto.tamanho + ", Sabor: " + produto.sabor + "\n";
//         } else {
//             mensagem += "Tipo: " + produto.tipo + ", Sabor: " + produto.sabor + "\n";
//         }
//     });
//     msg.innerHTML = mensagem;
// });
    

// Prof
let item = [];
frm.addEventListener("submit", (e) => {
    e.preventDefault();

    let index;
    let produto;
    let detalhe = "";

    if(frm.rbPizza.checked){
        index = frm.inPizza.selectedIndex;
        produto = frm.inPizza.options[index].text;
    }
    else {
        index = frm.inBebida.selectedIndex;
        produto = frm.inBebida.options[index].text;
    }

    detalhe = frm.inDetalhes.value;
    item.push(produto + " - " + detalhe)
    msg.innerHTML = item.join("\n");
    frm.reset();
    frm.rbPizza.dispatchEvent(new Event("click"));
});
