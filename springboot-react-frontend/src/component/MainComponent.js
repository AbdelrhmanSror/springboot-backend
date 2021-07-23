import React from 'react';
import CustomerService from '../service/CustomerService';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

class MainComponent extends React.Component {
    constructor(props) {
      super(props);
      //any number for country other than mentioned in the country list code number ,would cause the respone to get all customers from all countries
      //0 considered as not valid state
      //1 considered as valid state
      this.state = {country:'6',state:'1',customers:[]};
  
      this.handleSubmit = this.handleSubmit.bind(this);
      this.handleChangeCountry = this.handleChangeCountry.bind(this);
      this.handleChangeState = this.handleChangeState.bind(this);

    }

    componentWillMount(){
        this.handleSubmitChange()   
    }

   handleSubmitChange(){
    CustomerService.getFilteredCustomers(this.state.country,this.state.state).then((response)=>{
        this.setState({customers:response.data});
    })       
   }
    handleSubmit(event){
      this.handleSubmitChange()    
      event.preventDefault();
     }
  
    handleChangeCountry(event) {
     this.setState({country: event.target.value});
    }
    handleChangeState(event) {
        this.setState({state: event.target.value});
       }
  
  
    render() {
    const classes =  makeStyles({
            table: {
            minWidth: 650,
            },
        })

      return (
      <div>
        <form onSubmit={this.handleSubmit}>

          <label>
            Pick Country To Filter:
            <select value={this.state.country} onChange={this.handleChangeCountry}>
             <option value="6">Show All</option>
              <option value="237">Cameroon</option>
              <option value="251">Ethiopia</option>
              <option value="212">Morocco</option>
              <option value="258">Mozambique</option>
              <option value="256">Uganda</option>
               </select>
          </label>

          <label>
            Validity State :
            <select value={this.state.state} onChange={this.handleChangeState}>
             <option value="1">Valid</option>
              <option value="0">Not Valid</option>
            </select>
          </label>

          <input type="submit" value="Submit" />
        </form>

        <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">

        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell align="right">Name</TableCell>
            <TableCell align="right">Phone Number</TableCell>
            <TableCell align="right">Country</TableCell>
            <TableCell align="right"></TableCell>
          </TableRow>
        </TableHead>

        <TableBody>

          {
          this.state.customers.map((customer) => (
            <TableRow key={'customer'}>
              <TableCell component="th" scope="row"> {customer.id}</TableCell>
              <TableCell align="right">{customer.name}</TableCell>
              <TableCell align="right">{customer.phoneNumber}</TableCell>
              <TableCell align="right">{customer.country}</TableCell>
              </TableRow>
          ))
          }
        </TableBody>
      </Table>
    </TableContainer>

        </div>

      );
    }
  }
  export default MainComponent;
