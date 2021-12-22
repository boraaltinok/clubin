import React from 'react';
import axios from 'axios'
import userservice from '../services/UserServices';
import {Navbar, Nav,Form,FormControl,Button}  from 'react-bootstrap';

class UserComponent extends React.Component{

    constructor(props){
        super(props)
        this.state ={
            users:[]
        }
        
    }
    componentDidMount(){
        userservice.getUsers().then((Response) =>{
            this.setState({users:Response.data})
        });
    }
    render(){
        return(
            <div>
                <Navbar bg="dark" variant="dark">
                  <Navbar.Brand href="#home">TecnoTab</Navbar.Brand>
                        <Nav className="mr-auto">
                            <Nav.Link href="#home">Home</Nav.Link>
                            <Nav.Link href="#features">Features</Nav.Link>
                            <Nav.Link href="#pricing">Pricing</Nav.Link>
                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                            <Button variant="outline-info">Search</Button>
                        </Form>
                </Navbar>
                <h1 className = "text-center">Users List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <th>User Id</th>
                            <th>Name</th>
                            <th>Password</th>
                            <th>Role</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            this.state.users.map(
                                user =>
                                <tr key = {user.id}>
                                    <td>{user.id}</td>
                                    <td>{user.userName}</td>
                                    <td>{user.password}</td>
                                    <td>{user.roles}</td>
                                </tr>
                            )
                            }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default UserComponent