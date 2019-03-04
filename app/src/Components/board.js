import React from 'react'
import Square from './square'

export default class Board extends React.Component {
    renderSquare(i, j) {
        return (
            <Square value={this.props.squares[i][j]}/>
        );
    }

    render() {
        return (


            <div>
                {this.props.squares.map((value, index) => {
                    return <div key={index} className="board-row">
                        {this.renderSquare(index, 0)}
                        {this.renderSquare(index, 1)}
                        {this.renderSquare(index, 2)}
                        {this.renderSquare(index, 3)}
                        {this.renderSquare(index, 4)}
                        </div>
                })}

            </div>
        );
    }
}