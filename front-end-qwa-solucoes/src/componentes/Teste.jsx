import React, {useState} from 'react'
import axios from 'axios'
import TabelaCadastros from './tabela/TabelaCadastros';
import PropTypes from 'prop-types'
import { ErrorMessage, Formik, Form as FormikForm, Field } from 'formik'  
import * as yup from 'yup'

  const validations = yup.object().shape({
        nome: yup.string().required('Nome deve ser preenchido'),
        sobrenome: yup.string().required(),
        cpf: yup.string().required(),
        dtNasc: yup.string().required(),
    })

const Teste = ({handleSubmit, initialValues}) => {

    const [cadastrosList, setCadastrosList] = useState([]);

    const [cadastro, setCadastro] = useState({});

    const [numeroVagas, setNumeroVagas] = useState(0);

  async  function cadastrar(){

        try {
          await axios.post(`http://localhost:8080/cadastros/1`, cadastro)
            .then((response) => {

                if (response.httpStatus === 201){
                    console.log(response)
                    console.log(response.data)
                    setCadastrosList(response.data);
                    alert("Cadastro efetuado com sucesso!")
                }             
            })
        } catch (error) {
            console.log(error)
        }
    }

    const handleChangeVagas = (event) => {
        const value = { ...numeroVagas }
        value[event.target.name] = event.target.value;
        setNumeroVagas(value)
    };

    const handleChangeCadastro = (event) => {
        const value = { ...cadastro }
        value[event.target.name] = event.target.value;
        setCadastro(value)
    };


    return (
        
        <>

        <div>
            

            <Formik initialValues={initialValues} onSubmit={handleSubmit} validationSchema={validations}>

                <FormikForm>

                <label htmlFor="vagas">Informe a quantidade de vagas:</label>
                <Field id="vagas" name="vagas" />


                <label htmlFor="nome">Nome:</label>
                <Field id="nome" name="nome" />
                <ErrorMessage component="span" name="nome"/>

                <label htmlFor="sobrenome">Sobrenome:</label>
                <Field id="sobrenome" name="sobrenome" />
                <ErrorMessage component="span" name="sobrenome"/>

                <label htmlFor="cpf">Cpf:</label>
                <Field id="cpf" name="cpf" />
                <ErrorMessage component="span" name="cpf"/>

                <label htmlFor="dtNasc">Data de nascimento:</label>
                <Field type='date' id="dtNasc" name="dtNasc" />
                <ErrorMessage component="span" name="dtNasc"/>

                <button>Cadastrar</button>

                </FormikForm>
            </Formik>

            <TabelaCadastros obj={cadastrosList}/>
        </div>
        </>
    )

    Teste.propTypes = {
        handleSubmit: PropTypes.func.isRequired,
        initialValues: PropTypes.object.isRequired
    }

}

export default Teste;