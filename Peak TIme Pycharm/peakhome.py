from flask import Flask, request
import mysql.connector
import pickle
import numpy as np

config = {
  'user': 'admin',
  'password': 'onthegomaster',
  'host': 'onthegosem.cejfldd25qcf.us-west-2.rds.amazonaws.com',
  'database': 'onthego',
  'raise_on_warnings': True
}

app = Flask(__name__)

#Load already trained prediction model
model = pickle.load(open('open.pkl', 'rb'))

@app.route("/predictpeaktime",methods=['POST'])
def predictpeaktime():
    temp=request.json;
    str = [temp["routeid"],temp["month"] , temp["year"] ,  temp["hour"] , temp["dayofweek"] , temp["noofpass"]]
    ar=[np.array(str)]
    peaktime= model.predict(ar)

    return "{}".format(peaktime[0])

if __name__ == "__main__":
    app.run()