import './styles.css';
import '../../App.css';
import { useNavigate } from 'react-router-dom';
import logo from '../../assets/images/ratatouille logo.jpg';
import backgroundImage from '../../assets/images/back.logo.jpg';

function TelaInicial() {
  const navigate = useNavigate();

  const irParaCadastro = () => {
    navigate('/cadastro');
  };

  const irParaCardapio = () => {
    navigate('/cardapio');
  };

  return (
    <>
      <div
        className="fundo-tela"
        style={{
          backgroundImage: `url(${backgroundImage})`,
        }}
      ></div>

      <div className="tela-inicial">
        <img src={logo} alt="Ratatouille" className="logo" />
        <h1>Bem-vindo ao</h1>
        <h1>Ratatouille</h1>

        <div className="btn-group">
          <button onClick={irParaCadastro}>Adicionar Prato</button>
          <button onClick={irParaCardapio}>Ver Cardápio</button>
        </div>
      </div>
    </>
  );
}

export default TelaInicial;
