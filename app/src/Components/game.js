import React from 'react';
import Board from './board'


export default class Game extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            squares: [['empty','empty','empty','empty','empty'],['empty','empty','empty','empty','empty'],
                ['empty','empty','empty','empty','empty'],['empty','empty','empty','empty','empty'],
                ['empty','empty','empty','empty','empty']],
            textAreaTxt: 'POSITION 1 3 EAST //sets the initial position for the robot as x, y.\n' +
            'FORWARD 3 //lets the robot do 3 steps forward\n' +
            'WAIT //lets the robot do nothing\n' +
            'TURNAROUND //lets the robot turn around\n' +
            'FORWARD 1 //lets the robot do 1 step forward\n' +
            'RIGHT //lets the robot turn right\n' +
            'FORWARD 2 //lets the robot do 2 steps forward'
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleTextAreaChange = this.handleTextAreaChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        fetch('/api/calculateNewPosition', {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain'
            },
            body: this.state.textAreaTxt,
        }).then(response => response.json())
            .then(data => {
                this.state.squares[data.x][ data.y] = data.direction;
                this.forceUpdate();
                //
                // this.setState({
                //     squares: update(this.state.squares, {1: {name: {$set: 'updated field name'}}})
                // })
                // // this.setState({ ...this.state.squares });
            });
    }

    handleTextAreaChange(event){
        this.setState({textAreaTxt: event.target.value});
    }

    render() {

        return (
            <div className="game">
                <div className="game-board">
                    <Board
                        squares={this.state.squares}
                    />
                </div>
                <div className="game-info">
                    <form onSubmit={this.handleSubmit}>
                        <textarea value={this.state.textAreaTxt} cols={100} rows={30} onChange={this.handleTextAreaChange}/>
                        <input type="submit" value="Submit" />
                    </form>
                </div>
            </div>
        );
    }
}