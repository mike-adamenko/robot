import React from 'react';
import Board from './board';
import {Button, Col, Container, Row, Form, FormGroup, Label, Jumbotron} from 'reactstrap';

export default class Game extends React.Component {
     script = 'POSITION 1 3 EAST //sets the initial position for the robot as x, y.\n' +
        'FORWARD 3 //lets the robot do 3 steps forward\n' +
        'WAIT //lets the robot do nothing\n' +
        'TURNAROUND //lets the robot turn around\n' +
        'FORWARD 1 //lets the robot do 1 step forward\n' +
        'RIGHT //lets the robot turn right\n' +
        'FORWARD 2 //lets the robot do 2 steps forward';

    constructor(props) {
        super(props);
        this.state = {
            squares: this.createSquares(5,5),
            textAreaTxt: this.script
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.clearForm = this.clearForm.bind(this);
        this.handleTextAreaChange = this.handleTextAreaChange.bind(this);
    }

    clearForm(){
        this.setState({squares: this.createSquares(5,5)});
    }

    createSquares(width, height){
        var result = [];
        for (var i = 0 ; i < width; i++) {
            result[i] = [];
            for (var j = 0; j < height; j++) {
                result[i][j] = 'empty';
            }
        }
        return result;
    }

    handleSubmit(event) {
        event.preventDefault();
        fetch('/api/calculateNewPosition', {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain'
            },
            body: this.state.textAreaTxt,
        }).then(response => {
            if (response.ok) return response.json();
            throw new Error('Something went wrong.');
        })
            .then(data => {
                    this.state.squares[data.y][data.x] = data.direction;
                    this.forceUpdate();
            })
            .catch(function (error) {
                console.log('Request failed', error);
            });
    }

    handleTextAreaChange(event) {
        this.setState({textAreaTxt: event.target.value});
    }

    render() {
        return (
            <div className="game">
                <Jumbotron>
                <Container>
                    <Row>
                        <Col> <Board squares={this.state.squares}/></Col>
                    </Row>
                    <Row>

                    </Row>
                    <Row>
                        <Col>
                        <Form onSubmit={this.handleSubmit}>

                            <textarea id="scriptText" className="form-control mb-3 mt-3" value={this.state.textAreaTxt} cols={100} rows={10}
                                      onChange={this.handleTextAreaChange}/>
                            <Button type="button" className="mr-2" onClick={this.clearForm}>Clear</Button>
                            <Button>Submit</Button>


                        </Form>
                    </Col>
                    </Row>
                </Container>
                </Jumbotron>
            </div>
        );
    }
}