
function validaCPF(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;
    var result=true;
	if (strCPF == "00000000000") result= false;

	for (i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
	Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10)) ) result= false;

	Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11) ) ) result= false;
    return result;
}

function mensagem(){
    alert("Os dados foram enviados com sucesso!!!");
}



function validacaoCampos() {
    var email = document.form.email.value;
    var cpf = document.form.cpf.value;
    var rg = document.form.rg.value;
    var result = email=="" || cpf=="" || rg=="";
    if(result){
        alert("Existe campo vazio!!!");
        return false;
    }else{
        if(validaCPF(cpf)){
                alert("dados cadastros com sucesso!!!");
                return true;
        }else{
            alert("cpf invalido!!!");
            return false;
        }
    }
}

function validacaoCampos2() {
    var email = document.form.email.value;
    var nome = document.form.nome.value;
    var tel = document.form.tel.value;
    var assunto = document.form.assu.value;
    var area = document.form.area.value;
    var result = email=="" || nome=="" || tel==""||assunto==""||area=="";
    if(result){
        alert("Existe campo vazio!!!");
        return false;
    }else{
        alert("dados cadastros com sucesso!!!");
        return true;
    }
}
function validaSenha(){
    var nome = document.form.nome.value;
    var senha = document.form.senha.value;
    if(nome=="usuario" && senha=="senha"){
        return true;
    }else{
        alert("Usuário ou senha inválida!!!");
    }
    return false;
}


function showhide(id){
    if(document.getElementById(id).style.display == 'none'){
        document.getElementById(id).style.display = 'block';
    }else{
        document.getElementById(id).style.display = 'none';
    }
}

function funcao(){
    $(".btn-menu").click(function () {
    $(".menu").show();
    });
    $(".btn-close").click(function () {
        $(".menu").hide();
    });
}
