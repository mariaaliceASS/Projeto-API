    function setCookie(name, value, days) {
        let expires = "";
        if (days) {
            const date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            expires = "; expires=" + date.toUTCString();
        }
        document.cookie = name + "=" + (value || "") + expires + "; path=/";
    }

    function getCookie(name) {
        const nameEQ = name + "=";
        const ca = document.cookie.split(';');
        for (let i = 0; i < ca.length; i++) {
            let c = ca[i];
            while (c.charAt(0) === ' ') c = c.substring(1, c.length);
            if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length, c.length);
        }
        return null;
    }

    function toggleTheme() {
        console.log("Botão clicado!"); // Verifica se a função está sendo chamada
        const currentTheme = getCookie("theme");
        const newTheme = currentTheme === "dark" ? "light" : "dark";

        setCookie("theme", newTheme, 7); 
        applyTheme(newTheme);
    }

    // Função para aplicar o tema
    function applyTheme(theme) {
        console.log("Aplicando tema:", theme); // Verifica o tema que está sendo aplicado
        document.body.className = theme; // Define a classe do body
    }

    // Carregar tema ao iniciar
    window.onload = () => {
        const savedTheme = getCookie("theme") || "light"; // padrão é 'light'
        applyTheme(savedTheme);
        console.log("Tema inicial:", savedTheme); // Verifica o tema inicial
    };

    // Adiciona o evento de clique no botão
    document.getElementById("theme-toggle").addEventListener("click", toggleTheme);




