import React, { useState } from 'react';
import './style.css';

//                  component                   //
export default function SelectBox() {

    const listItem = [
        { name: '전국', vlaue: ''  },
        { name: '수도권', vlaue: ''  },
        { name: '지방', vlaue: ''  },
        { name: '서울', vlaue: ''  },
        { name: '부산', vlaue: ''  },
        { name: '대구', vlaue: ''  },
        { name: '인천', vlaue: ''  },
        { name: '광주', vlaue: ''  },
        { name: '대전', vlaue: ''  },
        { name: '울산', vlaue: ''  },
        { name: '세종', vlaue: ''  },
        { name: '경기', vlaue: ''  },
    ]

    //                  state                  //
    const [show, setShow ] = useState<boolean>(false);

    //                  event handler                   //
    const onButtonClickHandler = () => {
        setShow(!show);
    };
    const onItemClickHandler = () => {

        setShow(false);
    };

    //                  render                  //
    const buttonClass = show ? 'select-close-button' : 'select-open-button';
    return (
        <div className='select-box'>
            <div className='select-none'>지역</div>
            {/* <div className='select-item'>서울</div> */}
            <div className={buttonClass} onClick={onButtonClickHandler} ></div>
            {show && 
            <div className='select-list'>
                {listItem.map((item) =>
                <div className='select-list-item-box' onClick={onItemClickHandler} >
                    <div className='select-item'>{item.name}</div>
                </div>
                )}
            </div>
            }
        </div>
    );
}
