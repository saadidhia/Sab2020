import React, { Component, Fragment } from "react";
import { Row } from "reactstrap";
import IntlMessages from "../../../helpers/IntlMessages";
import { Colxx, Separator } from "../../../components/common/CustomBootstrap";
import Breadcrumb from "../../../containers/navs/Breadcrumb";
import axios from 'axios'
import { Redirect, Route, Switch } from 'react-router-dom';
import {API_CLIENT_ADD,API_CLIENT_GET}from '../../../constants/defaultValues'
import 'react-phone-number-input/style.css'
import PhoneInput from 'react-phone-input-2'
import 'react-phone-input-2/lib/style.css'
import {

  
  UncontrolledDropdown,
  DropdownToggle,
  DropdownItem,
  DropdownMenu
 
} from "reactstrap";

export default class Client extends Component {
  constructor(props) {
    super(props)

     this.state={
       name:'',
       email:'',
       adresse:'',
       rcc:'',
       phone:'',
       messageAdded:false,
       clients:[]
     }
     this.refresh=this.refresh.bind(this)
    
  }


 
                                                       

  onChange = (e) => {
    /*
      Because we named the inputs to match their
      corresponding values in state, it's
      super easy to update the state
    */
console.log(e.target);
    this.setState({ [e.target.name]: e.target.value });
 
  }
   refresh(){
    axios.get(API_CLIENT_GET).then(response=>{
        this.setState({
            clients:response.data
        })
    }).catch(
        error=>{console.log(error)}
    )
   }
  componentDidMount(){
      this.refresh();
  }

  addClient = e => { 
   e.preventDefault();
    // get our form data out of state
    const { name,email,adresse,rcc,phone } = this.state;

    axios.post(API_CLIENT_ADD, { name,email,adresse,rcc,phone})
      .then((result) => {
        this.refresh();
      
    this.setState={
        name:''
    }

        
        
      }).then((error)=>{
        console.log(error)
      });
}

 
    render() {
      const { name,email,adresse,rcc,messageAdded,phone } = this.state;
    // const messageIsAdded=this.state.messageAdded===true ? (<h1>the Client is added</h1>) : (<h1></h1>) 
        return (
            <Fragment>
            <Row>
              <Colxx xxs="12">
                <Breadcrumb heading="menu.second" match={this.props.match} />
                <div className="text-zero top-right-button-container">
              <UncontrolledDropdown>
                <DropdownToggle
                  caret
                  color="primary"
                  size="lg"
                  outline
                  className="top-right-button top-right-button-single">
                  <IntlMessages id="pages.actions" />
                </DropdownToggle>
                <DropdownMenu>
                  <DropdownItem header>
                    <IntlMessages id="pages.header" />
                  </DropdownItem>
                  <DropdownItem disabled>
                    <IntlMessages id="pages.delete" />
                  </DropdownItem>
                  <DropdownItem>
                    <IntlMessages id="pages.another-action" />
                  </DropdownItem>
                  <DropdownItem divider />
                  <DropdownItem>
                    <IntlMessages id="pages.another-action" />
                  </DropdownItem>
                </DropdownMenu>
              </UncontrolledDropdown>
            </div>
                <Separator className="mb-5" />
              </Colxx>
            </Row>
            <Row>
              <Colxx xxs="12" className="mb-4">
                <p><IntlMessages id="menu.second"/></p>
                
                <form onSubmit={e=>this.addClient(e)}>
                <p><label>Name       :    </label>
                <input onChange={this.onChange}type="text" name="name" value={name} required/></p>
                <p><label>email      :    </label>
                <input onChange={this.onChange} type="email" name="email" value={email} required/></p>
             
               
                <p><label>Adresse     :    </label>
                <input onChange={this.onChange} type="text" name="adresse" value={adresse} required/></p>
               <p><label>RCC     :    </label>
                <input onChange={this.onChange} type="text" name="rcc" value={rcc} required/></p>
                <p><label>Telephone     :    </label>
                <PhoneInput value={phone}
  onChange={phone => this.setState({ phone })} ></PhoneInput></p>
                <div className="row">
                
                
              <button className="btn btn-success" type="submit" >Add </button>
             {messageAdded===true && <h1>Client Is added</h1>}

              </div>
              </form>
              
   <table className="table" >
  
       <thead> 
           <tr>
       <th>name</th>
       <th>email</th>
       <th>adresse</th>
       <th>rcc</th>
       </tr>
       </thead>
       <tbody>
                  {
                      this.state.clients.map(client=>
                    <tr key={client.id}> 
                  
                      <td>{ client.name}</td>
                      <td>{client.email}</td>
                      <td>{client.adresse}</td>
                      <td>{client.rcc}</td>
                     

                  </tr>
                 )
                  }
              </tbody>
       
   </table>
        
             

               </Colxx>

            </Row>
            </Fragment>
        )
    }
}
